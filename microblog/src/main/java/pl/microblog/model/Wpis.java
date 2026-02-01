package pl.atins.microblog;

import javax.persistence.*;

@Entity
@Table(name = "wpis")
public class Wpis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
