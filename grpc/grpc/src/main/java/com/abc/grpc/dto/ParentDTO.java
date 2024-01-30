package com.abc.grpc.dto;

import java.util.Set;

public class ParentDTO {
    private Long id;
    private String name;

    private Set<ChildrenDTO> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ChildrenDTO> getChildren() {
        return children;
    }

    public void setChildren(Set<ChildrenDTO> children) {
        this.children = children;
    }
}
