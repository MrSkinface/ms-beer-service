package ua.mike.microbeerservice.models;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageableBeerList extends PageImpl<Beer> {

    public PageableBeerList(List<Beer> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public PageableBeerList(List<Beer> content) {
        super(content);
    }
}
