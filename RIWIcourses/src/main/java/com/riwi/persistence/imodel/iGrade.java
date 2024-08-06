package com.riwi.persistence.imodel;

import com.riwi.entities.grade;
import com.riwi.persistence.CRUD.*;

import java.util.ArrayList;

public interface iGrade extends createModel<grade>,
        readByidModel<grade>,
        readModel<grade>,
        updateModel<grade>,
        deleteModel {
        ArrayList<grade> readGradeByid(int id);
}
