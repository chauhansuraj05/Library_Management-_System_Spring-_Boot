package com.library.service;

import com.library.dto.*;

public interface AuthService {

    String register(RegisterRequest r);

    String login(LoginRequest r);
}
