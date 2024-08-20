import os
import shutil


def copy_files(src_dir, dst_dir, base_dir):
    for root, _, files in os.walk(src_dir):
        for file in files:
            src = os.path.join(root, file)
            dst = os.path.join(dst_dir, os.path.relpath(src, base_dir))
            os.makedirs(os.path.dirname(dst), exist_ok=True)
            shutil.copy2(src, dst)
            print(f"Copied {src} to {dst}")


def handle_versions(base_templates, version, output_dir):
    for i in range(1, version + 1):
        version_dir = os.path.join(base_templates, f"v{i}")
        if not os.path.exists(version_dir):
            print(f"Version {i} does not exist - skipping")
            continue
        print(f"Copying version v{i} from {version_dir}")
        copy_files(version_dir, output_dir, version_dir)


if __name__ == "__main__":
    base_templates = os.getenv('INPUT_BASE_TEMPLATES')
    custom_templates = os.getenv('INPUT_CUSTOM_TEMPLATES')
    version = int(os.getenv('INPUT_VERSION'))
    output_dir = 'tmp/templates'

    print(f"Base templates: {base_templates}")
    print(f"Custom templates: {custom_templates}")
    print(f"Version: {version}")
    print(f"Output templates: {output_dir}")

    handle_versions(base_templates, version, output_dir)
    copy_files(custom_templates, output_dir, custom_templates)
