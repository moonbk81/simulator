package simulator.model;

public class Adapter extends Profile {
    private int sourceType;
    private int complexity;
    private int memoryConsumption;

    public Adapter() {
    }

    public Adapter(int sourceType, int complexity, int memoryConsumption) {
        this.sourceType = sourceType;
        this.complexity = complexity;
        this.memoryConsumption = memoryConsumption;
    }

    public interface IAdapter {
        public String getName();
    }

    public abstract class AbstractAdapter implements IAdapter {
        protected  IAdapter adapter;
        public AbstractAdapter(IAdapter adapter) {
            this.adapter = adapter;
        }

        public abstract String getName();
    }

    public class SingleAdapter implements IAdapter {
        public String getName() {
            return "Adapter";
        }
    }

    public class SourceTypeFireAdapter extends AbstractAdapter {
        public SourceTypeFireAdapter(IAdapter adapter) {
            super(adapter);
        }

        @Override
        public String getName() {
            return String.format(" Fire Alarm %s", adapter.getName());
        }
    }
}