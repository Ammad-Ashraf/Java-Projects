package ModelPart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DestinationDAO 
{
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template)
    {
        this.template = template;
    }

    // Create
    public int save(destinationBean destination) 
    {
        String sql = "insert into destinations (name, category, description) values('" 
                     + destination.getName() + "','" 
                     + destination.getCategory() + "','"
                     + destination.getDescription() + "')";
        return template.update(sql);
    }

    // Update
    public int update(destinationBean destination)
    {
        String sql = "update destinations set name='" + destination.getName() +
                     "', category='" + destination.getCategory() + 
                     "', description='" + destination.getDescription() +
                     "' where id=" + destination.getId();
        return template.update(sql);
    }

    // Delete
    public int delete(int id) 
    {
        String sql = "delete from destinations where id=" + id;
        return template.update(sql);
    }

    // Read a single entry
    public destinationBean getDestinationById(int id)
    {
        String sql = "select * from destinations where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(destinationBean.class));
    }

    // Read all entries
    public List<destinationBean> getAllDestinations() {
        return template.query("select * from destinations", new RowMapper<destinationBean>() {
            public destinationBean mapRow(ResultSet rs, int row) throws SQLException {
                destinationBean d = new destinationBean();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setCategory(rs.getString("category"));
                d.setDescription(rs.getString("description"));
                return d;
            }
        });
    }
}

