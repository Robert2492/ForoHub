package com.alura.ForoHub.domain.topic.validation;

import com.alura.ForoHub.domain.topic.TopicDataUpdate;
import com.alura.ForoHub.domain.topic.UpdateTopic;
import com.alura.ForoHub.domain.user.User;

public interface UpdateValidation {
    void validate(TopicDataUpdate data, User user);

    void validate(UpdateTopic data, User user);
}
