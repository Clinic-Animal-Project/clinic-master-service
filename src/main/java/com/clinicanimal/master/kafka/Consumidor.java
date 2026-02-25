package com.clinicanimal.master.kafka;

import com.clinicanimal.master.aplication.mapper.PersonalMapper;
import com.clinicanimal.master.domain.model.Personal;
import com.clinicanimal.master.domain.repository.PersonalRepository;
import com.clinicanimal.master.web.dto.personal.PersonalRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Log4j2
public class Consumidor {
    private final PersonalRepository personalRepository;
    private final PersonalMapper  personalMapper;

    @KafkaListener(topics = Constantes.TOPICO,groupId = "master-group")
    public void receiveRegistrar(PersonalRequestDto personalRequestDto) {
        System.out.println("EL MENSAJE DEL TOPICO ES: " + personalRequestDto);
        try{
            Personal personal = personalMapper.toEntity(personalRequestDto);
            personal.setFechaRegistro(LocalDate.now());
            personalRepository.save(personal);
            log.info("Personal registrado com sucesso");
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }
}
