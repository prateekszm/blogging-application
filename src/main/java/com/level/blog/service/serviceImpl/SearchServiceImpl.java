package com.level.blog.service.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.blog.entity.User;
import com.level.blog.payload.UserDto;
import com.level.blog.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private EntityManager em;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<UserDto> searchUser(Map<String, String> userDetails) {
		StringBuilder query = new StringBuilder("select e from User as e where ");
		userDetails.forEach((column, value) -> {
			String strHelper = column + " like " + "'%" + value + "%'" + " and ";
			query.append(strHelper);
		});
	
		String hqlQuery = query.toString().substring(0, query.length() - 4);
//		String sql = "select e from User as e where email like 'i%' and about like 'Hi%' and firstName like '%prateek%'";
		TypedQuery<User> query3= em.createQuery(hqlQuery,User.class);
		List<User> users = query3.getResultList();

		List<UserDto> userDtos = users.stream().map(user -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		
		return userDtos;
	}

}
