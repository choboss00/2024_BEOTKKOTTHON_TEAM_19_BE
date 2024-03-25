package com.example.feelsun.config.jwt.refreshToken;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponse {

        private String accessToken;

        public RefreshTokenResponse(String accessToken) {
            this.accessToken = accessToken;
        }

}
