package com.clinicanimal.master.web.advice;

import com.clinicanimal.master.web.dto.common.GenericResponseDto;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // No interceptar métodos del GlobalExceptionHandler (ya devuelven GenericResponseDto)
        return !returnType.getDeclaringClass().equals(GlobalExceptionHandler.class);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // Protección extra: si por alguna razón ya es GenericResponseDto, no envolver de nuevo
        if (body instanceof GenericResponseDto) {
            return body;
        }
        if (body == null) {
            return null;
        }
        return GenericResponseDto.ok(body);
    }
}
