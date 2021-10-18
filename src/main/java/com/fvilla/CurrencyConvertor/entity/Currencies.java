package com.fvilla.CurrencyConvertor.entity;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currencies {

    @JsonProperty("oficial")
    private Value dolarOficial;

    @JsonProperty("blue")
    private Value dolarBlue;

    @JsonProperty("oficial_euro")
    private Value euroOficial;

    @JsonProperty("blue_euro")
    private Value euroBlue;

    @JsonProperty("last_update")
    private String lastUpdate;

    public Currencies() {
    }

    public Currencies(Value dolarOficial, Value dolarBlue, Value euroOficial, Value euroBlue, String lastUpdate) {
        this.dolarOficial = dolarOficial;
        this.dolarBlue = dolarBlue;
        this.euroOficial = euroOficial;
        this.euroBlue = euroBlue;
        this.lastUpdate = lastUpdate;
    }

    public Value getDolarOficial() {
        return dolarOficial;
    }

    public void setDolarOficial(Value dolarOficial) {
        this.dolarOficial = dolarOficial;
    }

    public Value getDolarBlue() {
        return dolarBlue;
    }

    public void setDolarBlue(Value dolarBlue) {
        this.dolarBlue = dolarBlue;
    }

    public Value getEuroOficial() {
        return euroOficial;
    }

    public void setEuroOficial(Value euroOficial) {
        this.euroOficial = euroOficial;
    }

    public Value getEuroBlue() {
        return euroBlue;
    }

    public void setEuroBlue(Value euroBlue) {
        this.euroBlue = euroBlue;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "dolarOficial=" + dolarOficial +
                ", dolarBlue=" + dolarBlue +
                ", euroOficial=" + euroOficial +
                ", euroBlue=" + euroBlue +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
