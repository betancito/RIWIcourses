package com.riwi.persistence.imodel;

import com.riwi.entities.course;
import com.riwi.persistence.CRUD.*;
import java.util.ArrayList;

public interface iCourse extends createModel<course>,
        readByidModel<course>,
        readModel<course>,
        updateModel<course>,
        deleteModel {
        ArrayList<course> read();
}
