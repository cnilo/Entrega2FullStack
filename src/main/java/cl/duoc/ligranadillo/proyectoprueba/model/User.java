package cl.duoc.ligranadillo.proyectoprueba.model;

import lombok.Data;

@Data
public class User {
    public class RegisterUserResult {
        private Long userId;

        public RegisterUserResult(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }
    }
}