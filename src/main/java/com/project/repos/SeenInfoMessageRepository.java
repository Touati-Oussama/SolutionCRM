package com.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.InboxMessageSeenInfo;

public interface SeenInfoMessageRepository extends JpaRepository<InboxMessageSeenInfo, String> {

}
