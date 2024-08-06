package com.riwi.persistence.imodel;

import com.riwi.entities.inscription;
import com.riwi.persistence.CRUD.*;

import java.util.ArrayList;

public interface iInscription extends createModel<inscription>,
        readByidModel<inscription>,
        readModel<inscription>,
        updateModel<inscription>,
        deleteModel {
    ArrayList<inscription> read();
}
