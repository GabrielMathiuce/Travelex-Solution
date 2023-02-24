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

    //Splito o nome levando em consideracao espacos em branco, criando assim um array, no qual eu itero
    // comecando com a variavel ja em 1, para pular o primeiro nome e eu obter somente o sobrenome.
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

    //Aqui assim como no metodo "getSurname", eu transformo o nome em um array e substituo a posicao 0
    //pelo primeiro caractere da mesma (ex: (M)athiuce) e adiciono um ponto final.
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
