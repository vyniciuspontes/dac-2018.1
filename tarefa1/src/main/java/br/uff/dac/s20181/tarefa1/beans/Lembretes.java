/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dac.s20181.tarefa1.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vyniciuspontes
 */
public class Lembretes {

    private final Map<String, List<String>> lembretesMap = new HashMap<>();

    public Lembretes() {
    }

    public Map<String, List<String>> getLembretesMap() {
        return lembretesMap;
    }

    public void addLembrete(String usuario, String lembrete) {

        List<String> userLembretes = this.lembretesMap.get(usuario);

        if (userLembretes == null) {
            userLembretes = new ArrayList<>();
            userLembretes.add(lembrete);
            this.lembretesMap.put(usuario, userLembretes);
        } else {

            userLembretes.add(lembrete);
        }
    }

}
