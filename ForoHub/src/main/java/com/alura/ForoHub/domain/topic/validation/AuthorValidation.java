package com.alura.ForoHub.domain.topic.validation;

import com.alura.ForoHub.domain.topic.TopicDataUpdate;
import com.alura.ForoHub.domain.topic.TopicRepository;
import com.alura.ForoHub.domain.topic.UpdateTopic;
import com.alura.ForoHub.domain.user.User;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class AuthorValidation implements UpdateValidation {
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(TopicDataUpdate data, User user) {
        var topic = topicRepository.findById(data.id()).orElse(null);

        assert topic != null;
        if (!Objects.equals(topic.getAuthor().getId(), user.getId())) {
            throw new ValidationException("Topico no pertenece a este usuario");
        }
    }

    @Override
    public void validate(UpdateTopic data, User user) {
        var topic = topicRepository.findById(user.getId()).orElse(null);
        assert topic != null;
        if (!Objects.equals(topic.getAuthor().getId(), user.getId())) {
            throw new ValidationException("Topico no le pertenece a este usuario");
        }
    }
}
