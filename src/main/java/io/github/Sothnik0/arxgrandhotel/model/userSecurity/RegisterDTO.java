package io.github.Sothnik0.arxgrandhotel.model.userSecurity;

import io.github.Sothnik0.arxgrandhotel.enums.Gender;
import io.github.Sothnik0.arxgrandhotel.enums.Roles;

public record RegisterDTO(String login, String password, Roles role, String name, String email, Gender gender, String message) {
}
