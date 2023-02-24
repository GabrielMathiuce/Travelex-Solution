package com.travelex.resolucao.classes;

import com.travelex.resolucao.exceptions.BlankNameException;

public abstract class ExchangeEntity {

    private String name;
    public ExchangeEntity(String name) {
        if(name.isBlank()) throw new BlankNameException();
        else this.name = name.trim();
    }

    public String getFirstName() {
        return this.name.split(" ")[0];
    }

    public String getSurname() {
        String surname = "";
        String[] fullname = this.name.split(" ");
        for(int i = 1; i < fullname.length; i++) {
            surname += fullname[i] + " ";
        }
        return surname.trim();
    }

    public String getFullNameToUpperCase() {
        return this.name.toUpperCase().trim();
    }

    public String getAbbreviatedName() {
        char abbreviatedMiddleName;
        String[] fullName = this.name.split(" ");
        abbreviatedMiddleName = fullName[1].charAt(0) ;
        fullName[1] = abbreviatedMiddleName + ".";
        String abbreviatedName = "";

        for(String name : fullName) {
            abbreviatedName += name + " ";
        }

        return abbreviatedName.trim();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.isBlank()) throw new BlankNameException();
        else this.name = name.trim();
    }


}
