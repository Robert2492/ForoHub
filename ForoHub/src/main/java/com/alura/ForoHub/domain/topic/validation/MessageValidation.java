package com.alura.ForoHub.domain.topic.validation;

import com.alura.ForoHub.domain.topic.DataTopic;
import com.alura.ForoHub.domain.topic.TopicRepository;
import com.alura.ForoHub.domain.topic.UpdateTopic;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageValidation implements ValidationTopical {
    @Autowired
    TopicRepository topicRepository;

    @Override
    public void validate(DataTopic dataTopic) {
        var message = topicRepository.existsByMessage(dataTopic.message());
        if (message) {
            throw new ValidationException(" Ya a sido registrado");
        }
    }

    @Override
    public void validate(UpdateTopic data) {
        var message = topicRepository.existsByMessage(data.message());
        if (message) {
            throw new ValidationException("Ya a sido registrado");
        }
    }
}
