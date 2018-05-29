package br.com.easy_therapy.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hamcrest.text.IsEmptyString;

import br.com.easy_therapy.entities.Cliente;
import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.persistence.DAOCliente;
import br.com.easy_therapy.persistence.DAOPsicologo;
import br.com.easy_therapy.util.Criptografia;

@WebServlet("/ControleCliente")
public class ControleCliente extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	
	public ControleCliente() {
		super();
	}
	
	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("acao");
		
		if("cadastrar".equalsIgnoreCase(action)){
			try {
				DAOPsicologo DaoP = new DAOPsicologo();
				DAOCliente d = new DAOCliente();
				
				String senha = request.getParameter("senha");
				String senhaconfirm = request.getParameter("senhaconfirm");
				String email = request.getParameter("email");
				
				int idpsicologo = Integer.parseInt(request.getParameter("idpsicologo"));
				
				if (senha.equals(senhaconfirm)) {						
					if(!d.hasEmail(email)) { 						
						Psicologo p = new Psicologo();
						p= DaoP.findById(idpsicologo);//hasPsicologo
						if (!p.getId().equals(null)) {						
						
							Cliente c = new Cliente();					
						
								c.setEmail(request.getParameter("email"));
								c.setSenha(Criptografia.encriptarSenha(senha));
								c.setNome(request.getParameter("nome"));
								c.setIdade(Integer.parseInt(request.getParameter("idade")));
								c.setPsicologo(p);
							
								d.insert(c);
							
								request.setAttribute("mensagem", "Cadastro realizado com sucesso, seja bem vindo!");
						}
						else
							request.setAttribute("mensagem", "Verifique CÓDIGO do seu Psicólogo");
					}				
					else
						request.setAttribute("mensagem", "Email já cadastrado, você mudou de Psicólogo/Terapeuta?");
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
				String email = request.getParameter("email");
				DAOCliente d = new DAOCliente();
				Cliente c = new Cliente();
				
				if(d.hasEmail(email)) {
					String senha = Criptografia.encriptarSenha(request.getParameter("senha"));
					
					if(d.hasEmailSenha(email, senha)) {
						
						HttpSession session = request.getSession();
						session.setAttribute("logon", c);
						
						request.getRequestDispatcher("area-restrita/listaPensamentos.jsp").forward(request, response);
					}
					else{
						throw new Exception("Senha incorreta.");
					}
				}
				else {
					request.setAttribute("mensagem","Usuário inexistente.");
					request.getRequestDispatcher("login.jsp").forward(request, response);
			
				}
			}
			catch (Exception e) {
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
			DAOCliente d = new DAOCliente();
			Integer i;
			
			try {
				i = Integer.parseInt(request.getParameter("idCliente"));
				d.delete(d.findById(i));
				request.setAttribute("mensagem","Cliente excluido com sucesso");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				request.getRequestDispatcher("VERIFICAR PARA ONDE VAI").forward(request, response);
			}
		}
		
		else if("editar".equalsIgnoreCase(action)){
			DAOCliente d = new DAOCliente();
			Integer i ;
			try {
				i=Integer.parseInt(request.getParameter("idCliente"));
				Cliente c = d.findById(i);
				
				request.setAttribute("cliente",c);
				
			} catch (Exception e) {
				request.setAttribute("mensagem", "Erro: " + e.getMessage());
			}finally {
				request.getRequestDispatcher("AREA RESTRITA EDITAR CLIENTE").forward(request, response);
			}
		}
		else if ("atualizar".equalsIgnoreCase(action))
			try {
				String senha = request.getParameter("senha");
				String senhaconfirm = request.getParameter("senhaconfirm");
				
				if (senha.equals(senhaconfirm)) {						
					DAOPsicologo DaoP = new DAOPsicologo();
					int idpsicologo = Integer.parseInt(request.getParameter("idpsicologo"));
					
					if (!DaoP.findById(idpsicologo).equals(null) || !DaoP.findById(idpsicologo).equals("") ) {
						
						Psicologo p = DaoP.findById(idpsicologo);
						DAOCliente d = new DAOCliente();
						Cliente c = new Cliente();
					
							c.setEmail(request.getParameter("email"));
							c.setSenha(Criptografia.encriptarSenha(senha));
							c.setNome(request.getParameter("nome"));
							c.setIdade(Integer.parseInt(request.getParameter("idade")));
							c.setPsicologo(p);
							
							d.update(c);
							
							request.setAttribute("mensagem", "Alteração realizada com sucesso!");
					}
					else
						request.setAttribute("mensagem", "Verifique o CÓDIGO do seu Psicólogo");
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

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	execute(request, response);
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	execute(request, response);
}

}

