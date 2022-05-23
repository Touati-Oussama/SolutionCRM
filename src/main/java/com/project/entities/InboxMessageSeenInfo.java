package com.project.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class InboxMessageSeenInfo {

	  @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;
	  
	  private LocalDateTime seenDate;
	  
	  @ManyToOne
	  @JoinColumn(name="user_id",nullable=false)
	  private User customUser;
	  
	  @ManyToOne
	  @JoinColumn(name="message_id",nullable=false)
	  private InboxMessage inboxMessage;

	public String getId() {
		return id;
	}

	public LocalDateTime getSeenDate() {
		return seenDate;
	}

	public User getCustomUser() {
		return customUser;
	}

	public InboxMessage getInboxMessage() {
		return inboxMessage;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSeenDate(LocalDateTime seenDate) {
		this.seenDate = seenDate;
	}

	public void setCustomUser(User customUser) {
		this.customUser = customUser;
	}

	public void setInboxMessage(InboxMessage inboxMessage) {
		this.inboxMessage = inboxMessage;
	}

	@Override
	public String toString() {
		return "InboxMessageSeenInfo [id=" + id + ", seenDate=" + seenDate + ", customUser=" + customUser
				+ ", inboxMessage=" + inboxMessage + "]";
	}
	  
	  
	  
}
