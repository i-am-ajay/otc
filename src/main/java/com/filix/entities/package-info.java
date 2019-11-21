@org.hibernate.annotations.GenericGenerator(name="item_id_seq",strategy="enhanced-sequence",
	parameters={
		@org.hibernate.annotations.Parameter(name="sequence_name", value="item_id_seq")
	})

@org.hibernate.annotations.GenericGenerator(name="item_assignment_seq", strategy="enhanced-sequence",
	parameters= {
			@org.hibernate.annotations.Parameter(name="sequence_name", value="item_assignment_seq")
	}
)
@org.hibernate.annotations.GenericGenerator(name="lookup_seq", strategy="enhanced-sequence",
		parameters = {
				@org.hibernate.annotations.Parameter(name="sequence_name", value="lookup_seq")
		}
)

@org.hibernate.annotations.GenericGenerator(name="emp_master_seq", strategy="enhanced-sequence",
	parameters = @Parameter(name="sequence_name", value="emp_master_seq")
)
@org.hibernate.annotations.GenericGenerator(name="consultant_master_seq", strategy = "enhanced-sequence", 
	parameters = @Parameter(name="sequence_name", value="consultant_master_seq")
)
@org.hibernate.annotations.GenericGenerator(name="patient_master_seq", strategy="enhanced-sequence",
	parameters= @Parameter(name="sequence_name", value="patient_master_seq")
)
@org.hibernate.annotations.GenericGenerator(name="sequence_master_seq", strategy="enhanced-sequence",
	parameters = @Parameter(name="sequence_name", value="patient_master_seq")
)
package com.filix.entities;

import org.hibernate.annotations.Parameter;
