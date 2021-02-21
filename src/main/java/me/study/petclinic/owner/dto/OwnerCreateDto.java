package me.study.petclinic.owner.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

public class OwnerCreateDto {

    @NotEmpty   // Server가 파라미터에 null값을 받지 않겠다는 의미
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String address;
    @NotEmpty
    private String city;
    // 숫자만 받는다.
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
