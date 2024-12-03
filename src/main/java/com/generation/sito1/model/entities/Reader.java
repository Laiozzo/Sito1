package com.generation.sito1.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Reader extends User
{
    @Column
            @Enumerated(EnumType.STRING)
    SubscriptionType subscriptionType;

    @ElementCollection
    @CollectionTable(name = "reader_tags", joinColumns = @JoinColumn(name = "reader_id"))
    @Column(name = "tag")
    Set<String> tags;

    //String tags;

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
