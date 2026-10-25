package bikeshare.repository;

import bikeshare.model.Receipt;

public interface RideSaver {
    void save(String memberId, Receipt receipt);
}