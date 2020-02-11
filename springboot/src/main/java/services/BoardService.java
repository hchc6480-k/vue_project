package services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardEntity;

@Service
public class BoardService implements BoardDao{

	SqlSession sqlsession;
	@Override
	public List<HashMap<String, Object>> SelectBoard() {
		return sqlsession.selectList("SelectBoard");
	}
	
	
}
