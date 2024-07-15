package com.alura.ForoHub.domain.topic.validation;

import com.alura.ForoHub.domain.topic.DataTopic;
import com.alura.ForoHub.domain.topic.TopicRepository;
import com.alura.ForoHub.domain.topic.UpdateTopic;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TitleValidation implements ValidationTopical{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public void validate(DataTopic dataTopic) {
        var title = topicRepository.existsByTitle(dataTopic.title());
        if (title) {
            throw new ValidationException("Ya existe este titulo");
        }
    }

    @Override
    public void validate(UpdateTopic data) {
        var title = topicRepository.existsByTitle(data.title());
        if (title) {
            throw new ValidationException("Ya existe este titulo");
        }
    }
}
