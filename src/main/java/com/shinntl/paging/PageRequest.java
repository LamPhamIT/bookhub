package com.shinntl.paging;

import com.shinntl.sorter.Sorter;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PageRequest implements Pageble{
    private Integer page;
    private Integer maxPageItem;

    private Sorter sorter;
    @Override
    public Integer getPage() {
        return this.page;
    }
    @Override
    public Integer getOffset() {
        if(page != null && maxPageItem != null) {
            return (this.page - 1) * this.maxPageItem;
        }
        return null;
    }

    @Override
    public Integer getLimit() {
        return this.maxPageItem;
    }
}
