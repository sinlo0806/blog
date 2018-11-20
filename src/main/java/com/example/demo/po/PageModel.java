package com.example.demo.po;

public class PageModel {
    /**
     * 最大页
     */
    private Integer maxPage;
    //当前页
    private Integer page;
    private Integer maxCount;
    private String title;
   private int indexOf=0;

    public int getIndexOf() {
        return indexOf;
    }

    public void setIndexOf(int indexOf) {



        this.indexOf = indexOf;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PageModel() {
    }

    public PageModel(Integer maxSize, Integer page) {
        setMaxCount(maxSize);
        this.page = page;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        //一页十个
        if(maxCount%10==0){
            this.maxPage=maxCount/10;
        }else{
            this.maxPage=(maxCount/10)+1;
        }
        this.maxCount = maxCount;
    }

    public Integer getMaxPage() {
        return maxPage;
    }
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
