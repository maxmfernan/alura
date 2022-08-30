package br.com.alura.model;

import java.util.List;

public class ResultadoToDo {
    private List<MetaData> metaData;
    private List<ToDo> results;
    public List<MetaData> getMetaData() {
        return metaData;
    }
    public void setMetaData(List<MetaData> metaData) {
        this.metaData = metaData;
    }
    public List<ToDo> getResults() {
        return results;
    }
    public void setResults(List<ToDo> results) {
        this.results = results;
    }

    
}
