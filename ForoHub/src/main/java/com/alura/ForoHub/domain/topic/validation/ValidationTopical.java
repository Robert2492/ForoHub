package com.alura.ForoHub.domain.topic.validation;

import com.alura.ForoHub.domain.topic.DataTopic;
import com.alura.ForoHub.domain.topic.UpdateTopic;

public interface ValidationTopical {
    void validate(DataTopic data);

    void validate(UpdateTopic data);
}
