package com.nibado.example.customargumentspring.component;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.UUID;

public class UserContextResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(final MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserContext.class);
    }

    @Override
    public Object resolveArgument(
            final MethodParameter methodParameter,
            final ModelAndViewContainer modelAndViewContainer,
            final NativeWebRequest nativeWebRequest,
            final WebDataBinderFactory webDataBinderFactory) {

        ServletWebRequest request = (ServletWebRequest) nativeWebRequest;

        UUID id = request.getHeader("user_id") == null ? null : UUID.fromString(request.getHeader("user_id"));
        String ip = request.getRequest().getRemoteAddr();

        return new UserContext(id, ip);
    }
}
