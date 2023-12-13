package com.project.food.interfaces;

import com.project.food.models.Hint;

import java.util.List;
import java.util.Objects;

public interface ItemOnClickListener {
    //void onClick(String id, boolean isSaved);

    void onClick(Hint hint, boolean isSaved);
}
