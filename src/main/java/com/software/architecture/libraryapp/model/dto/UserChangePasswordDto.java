package com.software.architecture.libraryapp.model.dto;

public class UserChangePasswordDto {

    public UserChangePasswordDto(String oldPassword, String newPassword, String newPasswordConfirmation) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPasswordConfirmation = newPasswordConfirmation;
    }

    private String oldPassword;
    private String newPassword;
    private String newPasswordConfirmation;

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPasswordConfirmation() {
        return newPasswordConfirmation;
    }
}
