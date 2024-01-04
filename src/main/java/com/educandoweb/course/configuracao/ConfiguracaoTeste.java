package com.educandoweb.course.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entidades.Categoria;
import com.educandoweb.course.entidades.Pedido;
import com.educandoweb.course.entidades.Produto;
import com.educandoweb.course.entidades.Usuario;
import com.educandoweb.course.entidades.enums.StatusPedido;
import com.educandoweb.course.repositorios.RepositorioCategoria;
import com.educandoweb.course.repositorios.RepositorioPedido;
import com.educandoweb.course.repositorios.RepositorioProduto;
import com.educandoweb.course.repositorios.RepositorioUsuario;

@Configuration
@Profile("teste")
public class ConfiguracaoTeste implements CommandLineRunner{
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		
		repositorioUsuario.saveAll(Arrays.asList(u1,u2));
		repositorioPedido.saveAll(Arrays.asList(o1, o2, o3));
		
		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
	
	
}