package com.travelex.resolucao.exceptions;

import java.time.LocalDateTime;

public class BlankNameException extends RuntimeException{

    private LocalDateTime exceptionTime;

    public BlankNameException() {
        super("Por favor insira um nome valido!", new Throwable("Nome em branco"));
        this.exceptionTime = LocalDateTime.now();
    }
}
