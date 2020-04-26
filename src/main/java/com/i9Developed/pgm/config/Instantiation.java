package com.i9Developed.pgm.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.i9Developed.pgm.domain.Post;
import com.i9Developed.pgm.domain.User;
import com.i9Developed.pgm.dto.AuthorDTO;
import com.i9Developed.pgm.dto.CommentDTO;
import com.i9Developed.pgm.repository.PostRepository;
import com.i9Developed.pgm.repository.UserRepository;

@Configuration
@Profile("dev")
public class Instantiation  implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		
		Post post2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia!","Acordei feliz hoje!",new AuthorDTO(maria));
		
		 
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!",Instant.now(),new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!",Instant.now(),new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!",Instant.now(),new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
		
		
		
		
	}

}
