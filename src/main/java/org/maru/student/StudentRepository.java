package org.maru.student;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

		@Query("select s from Student s join s.rank r where r.rk_code=?1")
		public List<Student> getByRank(int rk_code);
}
