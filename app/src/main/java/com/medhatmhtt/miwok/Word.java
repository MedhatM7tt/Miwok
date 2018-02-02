package com.medhatmhtt.miwok;

public class Word {
    private String miwokWord,englishWord;
    private int imageResourceId=-1;
    private int recordResource;

    public Word(String miwokWord, String englishWord, int imageResourceId, int recordResource) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.imageResourceId = imageResourceId;
        this.recordResource = recordResource;
    }
    public Word(String miwokWord, String englishWord, int recordResource) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.recordResource = recordResource;
    }
    public Word(String miwokWord, String englishWord) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
    }
    public void setRecordResource(int recordResource) {
        this.recordResource = recordResource;
    }

    public int getRecordResource() {
        return recordResource;
    }


    public boolean hasImage(){
        return imageResourceId!=-1;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getMiwokWord() {
        return miwokWord;
    }
    public String getEnglishWord() {
        return englishWord;
    }

    public void setMiwokWord(String miwokWord) {
        this.miwokWord = miwokWord;
    }
    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }
}
