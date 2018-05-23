package br.com.easy_therapy.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.entities.Registro;
import br.com.easy_therapy.persistence.DAOPsicologo;
import br.com.easy_therapy.persistence.DAORegistro;
import br.com.easy_therapy.util.Criptografia;

import java.util.Date;

@WebServlet("/ControleRegistro")
public class ControleRegistro {
	private static final long serialVersionUID = 1L;

	public ControleRegistro() {
		super();
	}

	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("acao");

		if("cadastrar".equalsIgnoreCase(action)){
			try {
				DAORegistro d = new DAORegistro();

				String situacao = request.getParameter("situacao");
				String pensamentosAutomaticos = request.getParameter("pensamentos_automaticos");
				String emocoes = request.getParameter("emocoes");
				String conclusao = request.getParameter("conclusao");
				String resultado = request.getParameter("resultado");

				Registro r = new Registro();

				//r.setCliente(1);
				r.setData(new Date());
				r.setSituacao(situacao);
				r.setPensamentos_automaticos(pensamentosAutomaticos);
				r.setEmocoes(emocoes);
				r.setConclusao(conclusao);
				r.setResultado(resultado);				

				d.insert(r);

				request.setAttribute("mensagem", "Cadastro do registro de pensamento realizado com sucesso!");

			}
			catch(Exception e) {
				request.setAttribute("Erro", e.getMessage());
			}
			finally {
				request.getRequestDispatcher("listaPensamentos.jsp").forward(request, response);
			}			
		} else if("editar".equalsIgnoreCase(action)){
			DAORegistro d = new DAORegistro();
			Integer i ;
			try {
				i=Integer.parseInt(request.getParameter("idRegistro"));
				Registro r = d.findById(i);
				
				request.setAttribute("registro",r);
				
			} catch (Exception e) {
				request.setAttribute("mensagem", "Erro: " + e.getMessage());
			}finally {
				request.getRequestDispatcher("editarPensamento.jsp").forward(request, response);
			}
		}
		else if ("atualizar".equalsIgnoreCase(action)) {
			try {
				DAORegistro d = new DAORegistro();

				int id = Integer.parseInt(request.getParameter("id"));
				String cliente = request.getParameter("cliente");
				String data = request.getParameter("data");
				String situacao = request.getParameter("situacao");
				String pensamentosAutomaticos = request.getParameter("pensamentos_automaticos");
				String emocoes = request.getParameter("emocoes");
				String conclusao = request.getParameter("conclusao");
				String resultado = request.getParameter("resultado");

				Registro r = new Registro();

				r.setId(id);
				//r.setCliente(1);
				r.setData(new Date());
				r.setSituacao(situacao);
				r.setPensamentos_automaticos(pensamentosAutomaticos);
				r.setEmocoes(emocoes);
				r.setConclusao(conclusao);
				r.setResultado(resultado);				

				d.update(r);

				request.setAttribute("mensagem", "Registro de pensamento atualizado com sucesso!");
			}
			catch(Exception e) {
				request.setAttribute("Erro", e.getMessage());
			}
			finally {
				request.getRequestDispatcher("listaPensamentos.jsp").forward(request, response);
			}	
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
}
