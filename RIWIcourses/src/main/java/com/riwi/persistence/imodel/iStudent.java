package com.riwi.persistence.imodel;

import com.riwi.entities.student;
import com.riwi.persistence.CRUD.*;

import java.util.ArrayList;

public interface iStudent extends
        createModel<student>,
        readByidModel<student>,
        readModel<student>,
        updateModel<student>,
        deleteModel{
    ArrayList<student> read();
}
