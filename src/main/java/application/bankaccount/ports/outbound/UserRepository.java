package application.bankaccount.ports.outbound;

import java.util.UUID;

public interface UserRepository {
    public boolean exists(UUID userId);
}
