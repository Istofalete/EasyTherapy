package br.com.easy_therapy.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.persistence.DAOPsicologo;
import br.com.easy_therapy.util.Criptografia;

@WebServlet("/ControlePsicologo")
public class ControlePsicologo {
	private static final long serialVersionUID = 1L;

	public ControlePsicologo() {
		super();
	}

	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("acao");

		if("cadastrar".equalsIgnoreCase(action)){
			try {
				DAOPsicologo d = new DAOPsicologo();

				String senha = request.getParameter("senha");
				String senhaconfirm = request.getParameter("senhaconfirm");

				int crp = Integer.parseInt(request.getParameter("crp"));

				if (senha.equals(senhaconfirm)) {									

					if (!d.hasCRP(String.valueOf(crp))) {

						Psicologo p = new Psicologo();

						p.setCrp(crp);
						p.setSenha(Criptografia.encriptarSenha(senha));
						p.setNome(request.getParameter("nome"));					

						d.insert(p);

						request.setAttribute("mensagem", "Cadastro realizado com sucesso, seja bem vindo!");
					}
					else
						request.setAttribute("mensagem", "CRP já cadastrado!");
				}
				else
					request.setAttribute("mensagem", "Verifique se você digitou as senhas corretamente");

			}
			catch(Exception e) {
				request.setAttribute("Erro", e.getMessage());
			}
			finally {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}			
		}

		else if ("login".equalsIgnoreCase(action)){
			try {
				String crp = request.getParameter("crp");
				DAOPsicologo d = new DAOPsicologo();
				Psicologo p = new Psicologo();

				if(d.hasCRP(crp)) {
					String senha = Criptografia.encriptarSenha(request.getParameter("senha"));

					if(d.hasCrpSenha(crp, senha)) {

						HttpSession session = request.getSession();
						session.setAttribute("logon", p);

						request.getRequestDispatcher("area-restrita/listaClientes.jsp").forward(request, response);
					}
					else
					{
						throw new Exception("Senha incorreta.");
					}
				}
				else 
				{
					request.setAttribute("mensagem","Usuário inexistente.");
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				request.setAttribute("mensagem",e.getMessage());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else if("logoff".equalsIgnoreCase(action)){

			HttpSession session = request.getSession();
			session.removeAttribute("logon");
			session.invalidate();

			response.sendRedirect("login.jsp");
		}
		else if ("excluir".equalsIgnoreCase(action)){
			DAOPsicologo d = new DAOPsicologo();
			Integer crp;

			try {
				crp = Integer.parseInt(request.getParameter("crp"));
				//VERIFICAR REGRAS PARA DELEÇÃO DE CONTA DE PSICOLOGO
				//d.delete(d.findById(crp));
				request.setAttribute("mensagem","Conta desativada com sucesso");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				request.getRequestDispatcher("VERIFICAR PARA ONDE VAI").forward(request, response);
			}
		}

		else if("editar".equalsIgnoreCase(action)){
			DAOPsicologo d = new DAOPsicologo();
			Integer i ;
			try {
				i=Integer.parseInt(request.getParameter("crp"));
				Psicologo p = d.findById(i);

				request.setAttribute("cliente",p);

			} catch (Exception e) {
				request.setAttribute("mensagem", "Erro: " + e.getMessage());
			}finally {
				request.getRequestDispatcher("AREA RESTRITA EDITAR CLIENTE").forward(request, response);
			}
		}
		else if ("atualizar".equalsIgnoreCase(action)) {
			try {
				String senha = request.getParameter("senha");
				String senhaconfirm = request.getParameter("senhaconfirm");

				if (senha.equals(senhaconfirm)) {					

					DAOPsicologo d = new DAOPsicologo();
					Psicologo p = new Psicologo();

					p.setSenha(Criptografia.encriptarSenha(senha));
					p.setNome(request.getParameter("nome"));	

					d.update(p);

					request.setAttribute("mensagem", "Alteração realizada com sucesso!");
				}
				else
					request.setAttribute("mensagem", "Verifique se você digitou as senhas corretamente");

			}
			catch(Exception e) {
				request.setAttribute("Erro", e.getMessage());
			}
			finally {
				request.getRequestDispatcher("CONFIGURACAO.jsp").forward(request, response);
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
