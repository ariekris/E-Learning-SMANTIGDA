package com.v1.e_learningsmantigda.Aspirasi;

public class ModelAspirasi {
    private String AspirasiId;
    private String aspirasi;
    private String sasaranAspirasi;

    public ModelAspirasi(){}

    public ModelAspirasi(String AspirasiId, String aspirasi, String sasaranAspirasi) {
        this.AspirasiId = AspirasiId;
        this.aspirasi = aspirasi;
        this.sasaranAspirasi = sasaranAspirasi;
    }

    public String getAspirasiId() {
        return AspirasiId;
    }

    public String getAspirasi() {
        return aspirasi;
    }

    public String getSasaranAspirasi() {
        return sasaranAspirasi;
    }
}
