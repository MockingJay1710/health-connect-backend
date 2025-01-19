package com.example.healthsystem.repository;

import com.example.healthsystem.model.Conversation;
import com.example.healthsystem.model.ConversationId;
import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, ConversationId> {

}
