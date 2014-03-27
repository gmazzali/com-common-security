package com.common.security.domain.model;

import java.io.Serializable;
import java.util.Set;

public class Participation implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user;

	private System system;

	private Set<Session> sessions;

	private Profile profile;

	private boolean enabled;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
}