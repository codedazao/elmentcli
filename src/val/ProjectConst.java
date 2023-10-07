package val;

import java.util.Objects;

public interface ProjectConst {
    String path = ProjectConst.class.getClassLoader().getResource("").getPath();
}
