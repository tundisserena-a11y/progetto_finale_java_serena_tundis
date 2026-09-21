package it.aulab.progetto_finale_docente.services;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.aulab.progetto_finale_docente.dtos.ArticleDto;
import it.aulab.progetto_finale_docente.models.Article;
import it.aulab.progetto_finale_docente.models.User;
import it.aulab.progetto_finale_docente.repositories.ArticleRepository;
import it.aulab.progetto_finale_docente.repositories.UserRepository;

@Service
public class ArticleService implements CrudService<ArticleDto, Article, Long> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Lettura di tutti gli articoli presenti nel database
    @Override
    public List<ArticleDto> readAll() {
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    // Lettura di un singolo articolo tramite chiave
    @Override
    public ArticleDto read(Long key) {
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    // Creazione e salvataggio di un nuovo articolo con associazione utente
    @Override
    public ArticleDto create(Article article, Principal principal, MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            User user = userRepository.findById(userDetails.getId()).get();
            article.setUser(user);
        }

        ArticleDto dto = modelMapper.map(articleRepository.save(article), ArticleDto.class);

        return dto;
    }

    @Override
    public ArticleDto update(Long key, Article model, MultipartFile file) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long key) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
