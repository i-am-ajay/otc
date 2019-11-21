package com.filix.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SequenceMaster {
	@Id
	@GeneratedValue(generator="sequence_master_seq")
	//@Column(name="")
	private int sequenceId;
}
